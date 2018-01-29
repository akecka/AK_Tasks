package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Badges {

    @JsonProperty("votes")
    private int votes;

    @JsonProperty("attachmentsByType")
    private AttachmentsByType attachmentsByType;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Badges badges = (Badges) o;

        if (votes != badges.votes) return false;
        return attachmentsByType != null ? attachmentsByType.equals(badges.attachmentsByType) : badges.attachmentsByType == null;
    }

    @Override
    public int hashCode() {
        int result = votes;
        result = 31 * result + (attachmentsByType != null ? attachmentsByType.hashCode() : 0);
        return result;
    }
}
