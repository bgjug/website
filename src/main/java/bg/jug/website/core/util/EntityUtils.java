package bg.jug.website.core.util;

import bg.jug.website.core.model.AbstractEntity;
import org.hibernate.engine.spi.EntityEntry;
import org.ocpsoft.logging.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class EntityUtils {

    private static final Logger LOGGER = Logger.getLogger(EntityUtils.class);

    public static <T extends AbstractEntity> void updateEntity(T persisted, T updated) {
        getAllFields(new LinkedList<Field>(), updated.getClass()).stream()
                .filter(EntityUtils::fieldIsSimple)
                .forEach(f -> updateFieldValue(f, updated, persisted));

    }

    private static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }

    private static <T extends AbstractEntity> void updateFieldValue(Field field, T fromEntity, T toEntity) {
        try {
            field.setAccessible(true);
            Object valueFromEntity = field.get(fromEntity);
            if (valueFromEntity != null) {
                field.set(toEntity, valueFromEntity);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * Field updates should be done on more primitive types. More complicated updates should be done manually as they
     * need to be attached to the Entity manager
     */
    private static boolean fieldIsSimple(Field field) {
        return !Modifier.isStatic(field.getModifiers()) &&
                !Collection.class.isAssignableFrom(field.getType()) &&
                !AbstractEntity.class.isAssignableFrom(field.getType()) &&
                !EntityEntry.class.isAssignableFrom(field.getType());
    }
}
