package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.Generated;

@Getter
@Setter
@ToString
public class FileData {

	@JsonProperty("filename")
	private String filename;

	@JsonProperty("size")
	private int size;

	@JsonProperty("language")
	private String language;

	@JsonProperty("type")
	private String type;

	@JsonProperty("raw_url")
	private String rawUrl;
}