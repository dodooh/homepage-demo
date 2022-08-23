package com.tera.homepage.model;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table("Media_asset")
public class MediaAsset {

    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    private Integer id;

    @PrimaryKeyColumn(name = "item_id", type = PrimaryKeyType.PARTITIONED)
    private Integer itemId;

    @Column("banner_url")
    private String bannerUrl;

    @Column("poster_url")
    private String posterUrl;

    @Column("thumbnail_url")
    private String thumbnailUrl;
}
