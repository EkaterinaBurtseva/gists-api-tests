package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(fluent = true)
public class FileInfoContent {
    @JsonProperty("content")
     String content;

    @JsonProperty("fileName")
    String fileName;
}
