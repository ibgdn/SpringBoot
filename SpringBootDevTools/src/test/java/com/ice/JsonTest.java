package com.ice;

import com.ice.controllertest.bean.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

/**
 * 10.JSON 测试
 */
@org.springframework.boot.test.autoconfigure.json.JsonTest
public class JsonTest {
    @Autowired(required = false)
    JacksonTester<Book> jacksonTester;

    // 测试 Json 序列化
    @Test
    public void jsonSerializeTest() {
        Book book = new Book();
        book.setId(1);
        book.setName("Java 核心技术");
        book.setAuthor("Cay S H");
        try {
            // json 内容是否一致
            Assertions.assertThat(jacksonTester.write(book))
                    .isEqualToJson("book.json");

            // 是否有名字为 name 的 key
            Assertions.assertThat(jacksonTester.write(book))
                    .hasJsonPathStringValue("@.name");

            // value 值是否与文件内容一致
            Assertions.assertThat(jacksonTester.write(book))
                    .extractingJsonPathStringValue("@.name")
                    .isEqualTo("Java 核心技术");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 测试 Json 反序列化
    @Test
    public void jsonDeserializeTest() {
        String context = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"Java 核心技术\",\n" +
                "  \"author\": \"Cay S H\"\n" +
                "}";
        try {
            Assertions.assertThat(jacksonTester.parseObject(context).getName())
                    .isEqualTo("Java 核心技术");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
