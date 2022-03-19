package ru.spliterash.validationWrapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolation;
import java.util.Collections;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class ValidationResult<O> {
    private final boolean success;
    private final String message;
    private final Set<ConstraintViolation<O>> set;

    public static <O> ValidationResult<O> success() {
        return new ValidationResult<>(true, "", Collections.emptySet());
    }
}
