CREATE TABLE items (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    description VARCHAR(512)
);

INSERT INTO items (name, price, description) VALUES
    ('ノートパソコン', 150000, '16GB RAM の薄型ノートPC'),
    ('ワイヤレスマウス', 2500, 'コンパクトで静音仕様のマウス'),
    ('バックパック', 8500, '13インチPCまで収納可能なリュック'),
    ('モニター', 32000, '27インチ/144Hz のゲーミングディスプレイ'),
    ('外付けSSD', 12000, 'USB3.2 Gen2 対応のポータブルストレージ'),
    ('ゲーミングキーボード', 19000, 'メカニカルスイッチ搭載／RGB対応');
