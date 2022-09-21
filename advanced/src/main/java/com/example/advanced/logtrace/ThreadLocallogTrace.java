package com.example.advanced.logtrace;

import com.example.advanced.trace.TraceId;
import com.example.advanced.trace.TraceStatus;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ThreadLocallogTrace implements LogTrace{


    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    //이제 직전로그의 traceId는 파라미터로 전달되는 것이 아니라 여기에 저장된다
   // private TraceId traceIdHolder; //traceId 동기화, 동시성 이슈 발생
    //쓰레드가 동시에 접근하면 동시성문제가 발생한다
    
    private ThreadLocal<TraceId> traceIdHolder = new ThreadLocal<>();

    @Override
    public TraceStatus begin(String message) {
        syncTraceId();
        TraceId traceId = traceIdHolder.get();
        Long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);
    }

    private void syncTraceId() {
    	TraceId traceId = traceIdHolder.get();
        if (traceId == null) {
        	//새로생성
            traceIdHolder.set(new TraceId());
        } else {
        	//트랜잭션 id유지 및 레벨 증가
        	traceIdHolder.set(traceId.createNextId());
        }
    }

    @Override
    public void end(TraceStatus status) {
        complete(status, null);

    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }

    private void complete(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();
        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(), addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs, e.toString());
        }

        releaseTraceId();
    }

    private void releaseTraceId() {
    	TraceId traceId = traceIdHolder.get();
    	//첫번째 레벨인지 확인하는 메소드
        if (traceId.isFirstLevel()) {
            traceIdHolder.remove();; //destroy
        } else {
        	traceIdHolder.set(traceId.createPreviousId());
        }
    }

    private static String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append((i == level - 1) ? "|" + prefix : "|   ");
        }
        return sb.toString();
    }



}
