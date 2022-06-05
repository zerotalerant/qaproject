package org.example.exceptions;

public class FieldCantBeEmptyException extends RuntimeException {
    public FieldCantBeEmptyException ( String message )
    {
        super ( message );
    }
}
