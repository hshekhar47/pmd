package org.hshekhar.pmd.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PMDResponse<T>
{
    private String error;
    private T data;

    public PMDResponse(String error) { this.error = error; }

    public PMDResponse(T data) { this.data = data; }
}
