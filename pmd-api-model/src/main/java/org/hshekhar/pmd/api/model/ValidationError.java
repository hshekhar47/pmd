package org.hshekhar.pmd.api.model;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends Exception
{
    List<String> errors;

    public ValidationError()
    {
        this.errors = new ArrayList<>();
    }

    public ValidationError addError(String message)
    {
        this.errors.add(message);
        return this;
    }

    public static ValidationError build()
    {
        return new ValidationError();
    }
}
