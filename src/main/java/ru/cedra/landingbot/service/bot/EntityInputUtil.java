package ru.cedra.landingbot.service.bot;

import ru.cedra.landingbot.anno.Step;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

public class EntityInputUtil<T> {

    public void performInput(Class<T> tClass) {
        List<Field> fields = Arrays.asList(tClass.getFields());
        Map<Integer, Field> stepFieldMap = new HashMap<>();
        fields.forEach(field -> {
            List<Annotation> annotations = Arrays.asList(field.getDeclaredAnnotations());
            Optional<Annotation> stepOpt = annotations.stream().filter(a->a.annotationType().equals(Step.class)).findFirst();
            if (stepOpt.isPresent()) {
                Step step = (Step) stepOpt.get();
                stepFieldMap.put(step.value(), field);
            }
        });


    }
}
