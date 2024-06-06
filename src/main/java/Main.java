import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        String json = readString("new_data.json");
        List<Employee> list = jsonToList(json);
        for (int i = 0; i < list.size(); i++) {
            String j = String.valueOf(list.get(i));
            System.out.println(j);
        }
    }

    private static List<Employee> jsonToList(String s) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        return objectMapper.readValue(s, typeFactory.constructCollectionType(List.class, Employee.class));
    }

    private static String readString(String s) throws IOException {
        return FileUtils.readFileToString(new File(s), StandardCharsets.UTF_8);

    }
}
