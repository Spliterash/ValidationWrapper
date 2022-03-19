package ru.spliterash.validationWrapper;

import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@RequiredArgsConstructor
public class ValidationService {
    private final Validator validator;

    public <O> ValidationResult<O> validate(O o) {
        Set<ConstraintViolation<O>> validate = validator.validate(o);

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