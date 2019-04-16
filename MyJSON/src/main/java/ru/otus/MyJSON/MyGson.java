package ru.otus.MyJSON;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public class MyGson {
    private StringBuilder json;
    private final static String BEGIN = "{";
    private final static String END = "}";

    public MyGson(StringBuilder json) {
        this.json = json;
        json.append(BEGIN);
    }

    public MyGson() {
        this.json = new StringBuilder();
    }

    public String toJson(Object object) {

        if (object == null) {
            return null;
        }
        String checkPrimitive = wrapPrimitiveToJson(object);
        if (checkPrimitive == null) {
            if (object.getClass().isArray()) {
                json.append(arrayToJson(object));
            } else
            if (object instanceof Collection) {
                Object[] array = ((Collection) object).toArray();
                json.append(arrayToJson(array));
            } else
            if (object instanceof Map) {
                json.append(mapToJson((Map)object));
            } else {
                json.append(easyObjectToJson(object));
            }

            String result = json.toString();
            json = new StringBuilder();
            return result;
        }
        return checkPrimitive;
    }

    private String mapToJson(Map<?,?> map) {
        StringBuilder json  = new StringBuilder("{");
        for (var entry: map.entrySet()) {
            json.append("\"")
                    .append(entry.getKey())
                    .append("\":")
                    .append(easyObjectToJson(entry.getValue()))
                    .append(",");
        }
        json.deleteCharAt(json.length()-1);
        json.append("}");
         return json.toString();
    }

    private String easyObjectToJson(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (var field : fields) {
            String name = field.getName();
            Object fieldValue = ReflectionHelper.getFieldValue(object, name);
            String value = "\"" + fieldValue + "\"";
            if (fieldValue.getClass().isArray()) {
                value = arrayToJson(fieldValue);
            }
            if (!(wrapPrimitiveToJson(fieldValue)==null)) {
                value = wrapPrimitiveToJson(fieldValue);
            }
            stringBuilder
                    .append("\"")
                    .append(name)
                    .append("\"")
                    .append(":")
                    .append(value)
                    .append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    private String wrapPrimitiveToJson(Object object) {

        if (object instanceof String) {
            return "\"" + object + "\"";
        }
        if (object instanceof Number) {
            return object.toString();
        }
        if (object instanceof Character) {
            return "\"" + object + "\"";
        } else if (object instanceof Boolean) {
            return "" + object;
        } else {
            return null;
        }
    }


    private String arrayToJson(Object object) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (object.getClass().getComponentType().isPrimitive()) {
            json.append(primitiveArrayToJson(object));
        } else if (object.getClass().getComponentType().getSimpleName().equals("String")) {
            String[] objects = (String[]) object;
            for (var obj : objects) {
                json.append(wrapPrimitiveToJson(obj))
                        .append(",");
            }
            json.deleteCharAt(json.length() - 1);
            json.append("]");
        } else {
            Object[] objects = (Object[]) object;
            for (var obj : objects) {
                json.append(easyObjectToJson(obj))
                        .append(",");
            }
            json.deleteCharAt(json.length() - 1);
            json.append("]");
        }

        return json.toString();
    }

    private String primitiveArrayToJson(Object object) {
        StringBuilder json = new StringBuilder();
        var typeObject = object.getClass().getComponentType().getTypeName();
        if (typeObject == "int") {
            int[] objects = (int[]) object;
            for (var obj : objects) {
                json.append(wrapPrimitiveToJson(obj))
                        .append(",");
            }
        }
        json.deleteCharAt(json.length() - 1);
        json.append("]");
        return json.toString();
    }
}
