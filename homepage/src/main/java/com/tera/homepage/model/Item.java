package com.tera.homepage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table("items")
public class Item {
    @PrimaryKeyColumn(value = "id",type = PrimaryKeyType.PARTITIONED)
    private Integer id;

    @PrimaryKeyColumn(value = "media_type",type = PrimaryKeyType.PARTITIONED)
    private MediaType mediaType;

    @PrimaryKeyColumn(value = "start_time",ordinal = 0, ordering = Ordering.DESCENDING)
    private LocalDateTime startTime;

    @PrimaryKeyColumn(value = "expired_time",ordinal = 1, ordering = Ordering.ASCENDING)
    private LocalDateTime expiredTime;

    @Column("title")
    private String title;

    @Column("description")
    private String description;

    @Column("actors")
    private List<String> actors;

    @Column("directors")
    private List<String> directors;

    @Column("channel_id")
    private Integer channelId;

    @Column("players")
    private List<String> player;

}
