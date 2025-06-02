package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TextGeneratorTest {

    @Test
    @Disabled
    public void whenGenerateTextCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        String expect = "I am a Petr Arsentev, Who are you?";
        Generator generator = new TextGenerator();
        String actual = generator.produce(template, map);
        assertThat(expect).isEqualTo(actual);
    }

    @Test
    @Disabled
    public void whenNoKeysInMapButExistInTemplateException() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String template = "I am ${old}, How old are ${subject}?";
        String expect = "I am 23, How old are ${subject}?";
        Generator generator = new TextGenerator();
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(Error.class);
    }

    @Test
    @Disabled
    public void whenKeysInMapButNotExistInTemplateException() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        map.put("old", "23");
        String template = "I am ${old}, How old are ${subject}?";
        String expect = "I am 23, How old are ${subject}?";
        Generator generator = new TextGenerator();
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(Error.class);
    }
}