package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AllGistsResponse {

	@JsonProperty("owner")
	private FileOwnerInformation fileOwnerInformation;

	@JsonProperty("commits_url")
	private String commitsUrl;

	@JsonProperty("comments")
	private int comments;

	@JsonProperty("forks_url")
	private String forksUrl;

	@JsonProperty("git_push_url")
	private String gitPushUrl;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("description")
	private String description;

	@JsonProperty("truncated")
	private boolean truncated;

	@JsonProperty("url")
	private String url;

	@JsonProperty("public")
	private boolean jsonMemberPublic;

	@JsonProperty("updated_at")
	private String updatedAt;

	@JsonProperty("html_url")
	private String htmlUrl;

	@JsonProperty("git_pull_url")
	private String gitPullUrl;

	@JsonProperty("comments_url")
	private String commentsUrl;

	@JsonProperty("files")
	private String files;

	@JsonProperty("id")
	private String id;

	@JsonProperty("user")
	private Object user;

	@JsonProperty("node_id")
	private String nodeId;
}