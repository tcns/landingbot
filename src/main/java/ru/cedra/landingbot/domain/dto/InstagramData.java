package ru.cedra.landingbot.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.cedra.landingbot.domain.dto.instagram.EntryData;

@Data
public class InstagramData {
    @JsonProperty("entry_data")
    private EntryData entryData;

}
