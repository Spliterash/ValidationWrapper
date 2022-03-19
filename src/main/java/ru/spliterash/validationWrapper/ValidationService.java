package ru.spliterash.validationWrapper;

import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.lang.reflect.Method;
import java.util.Set;

@RequiredArgsConstructor
public class ValidationService {
    private final Validator validator;

    public <O> ValidationResult<O> validateMethod(O obj, Method method, Object[] params) {
        return wrap(validator.forExecutables().validateParameters(obj, method, params));
    }

    public <O> ValidationResult<O> validateObject(O o) {
        return wrap(validator.validate(o));
    }

    public <O> ValidationResult<O> wrap(Set<ConstraintViolation<O>> validate) {
        // Всё чики пуки
        if (validate.isEmpty())
            return ValidationResult.success();

        StringBuilder builder = new StringBuilder();

        for (ConstraintViolation<?> c : validate) {
            String fieldName = JavaXUtils.getFieldName(c);
            if (fieldName != null)
                builder.append(fieldName).append(": ");
            builder.append(c.getMessage()).append("\n");
        }

        return new ValidationResult<>(false, builder.toString(), validate);
    }
}