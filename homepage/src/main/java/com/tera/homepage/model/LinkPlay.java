package com.tera.homepage.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@NoArgsConstructor
@Getter
@Setter
@Table("link_play")
public class LinkPlay{
    @PrimaryKeyColumn(name = "item_id", type = PrimaryKeyType.PARTITIONED)
    private Integer itemId;

    @Column("url")
    private String url;

    @PrimaryKeyColumn(name = "platform", type = PrimaryKeyType.PARTITIONED)
    private Platform platform;

}
