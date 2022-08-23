CREATE KEYSPACE IF NOT EXISTS homepage WITH REPLICATION = {'class':'SimpleStrategy', 'replication_factor' : 1};
USE homepage;

CREATE TABLE link_play
(
    id       INT,
    item_id INT,
    url      TEXT,
    platform TEXT,
    PRIMARY KEY((id,item_id,platform))
);

CREATE TABLE media_asset
(
    id            INT,
    item_id      INT,
    banner_url    TEXT,
    poster_url    TEXT,
    thumbnail_url TEXT,
    PRIMARY KEY((id,item_id))
);

CREATE TABLE items
(
    id           INT,
    media_type    TEXT,
    start_time   TIMESTAMP,
    expired_time TIMESTAMP,
    title        TEXT,
    description  TEXT,
    actors       LIST<TEXT>,
    directors    LIST<TEXT>,
    players      LIST<TEXT>,
    channel_id   INT,
    PRIMARY KEY((id,media_type),start_time,expired_time)
) WITH CLUSTERING ORDER BY (start_time DESC , expired_time ASC);
