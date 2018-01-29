package com.crud.tasks.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trello {

    @JsonProperty("board")
    private int board;

    @JsonProperty("card")
    private int card;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trello trello = (Trello) o;

        if (board != trello.board) return false;
        return card == trello.card;
    }

    @Override
    public int hashCode() {
        int result = board;
        result = 31 * result + card;
        return result;
    }
}
