package com.example.android.myapplication.operation.messages;

/**
 * Created by angebagui on 24/07/2015.
 */
public class NetworkOperationEvent {

    final public static int HAS_FAILED = -1;
    final public static int HAS_FINISHED_ALL = 10;
    final public static int HAS_FINISHED_ONE = 1;
    final public static int HAS_STARTED = 0;
    final public static int HAS_FAILURE = 4;
    final public static int HAS_NO_CONNECTION = 5;



    private String mMessage;
    private int mStatus;
    private int mType;


    public NetworkOperationEvent(int status) {
        this.mStatus = status;
    }

    public NetworkOperationEvent(int status,int type) {
        this.mStatus = status;
        this.mType = type;
    }

    public NetworkOperationEvent(int status, String message) {
        this.mStatus = status;
        this.mMessage = message;
    }

    public NetworkOperationEvent(int status, String message, int type) {
        this.mStatus = status;
        this.mMessage = message;
        this.mType = type;
    }
    public String getMessage() {
        return mMessage;
    }

    public boolean hasFailed() {
        return (mStatus == HAS_FAILED);
    }

    public boolean hasFinishedAll() {
        return (mStatus == HAS_FINISHED_ALL);
    }

    public boolean hasFinishedOne() {
        return (mStatus == HAS_FINISHED_ONE);
    }

    public boolean hasStarted() {
        return (mStatus == HAS_STARTED);
    }
    public boolean hasFailure(){
        return (mStatus == HAS_FAILURE);
    }
    public boolean hasNoConnexion(){
        return (mStatus==HAS_NO_CONNECTION);
    }

    public void setMessage(String message) {
        this.mMessage = message;
    }

}
