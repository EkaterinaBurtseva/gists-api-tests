package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class GistInfo {
    @JsonProperty("description")
    String description;
    @JsonProperty("public")
    boolean publicState;
    @JsonProperty("files")
    Object files;
    @JsonProperty("fileContent")
    FileInfoContent fileInfoContent;

}
