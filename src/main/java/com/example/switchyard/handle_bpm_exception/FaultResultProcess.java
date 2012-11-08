package com.example.switchyard.handle_bpm_exception;

import org.switchyard.component.bpm.StartProcess;

public interface FaultResultProcess
{
    @StartProcess
    public String start(String data);
    
//    @SignalEvent("myEvent")
//    public void signal(String data);
//    @AbortProcessInstance
//    public void stop(String data);
}
