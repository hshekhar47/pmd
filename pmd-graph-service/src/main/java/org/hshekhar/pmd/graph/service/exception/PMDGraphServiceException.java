package org.hshekhar.pmd.graph.service.exception;

public class PMDGraphServiceException extends Exception
{
    public PMDGraphServiceException(String message)
    {
        super(message);
    }

    public PMDGraphServiceException(Throwable cause)
    {
        super(cause);
    }
}
