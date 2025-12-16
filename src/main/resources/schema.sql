CREATE TABLE items (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    description VARCHAR(512)
);

INSERT INTO items (name, price, description) VALUES
    ('リンゴ', 150, '新鮮な青森産リンゴ'),
    ('バナナ', 120, '熟した黄色いバナナ'),
    ('オレンジ', 200, 'ビタミンC豊富なオレンジ'),
    ('ぶどう', 800, '甘い巨峰ぶどう'),
    ('いちご', 1200, '新鮮な赤いいちご'),
    ('みかん', 250, '甘酸っぱいみかん'),
    ('スイカ', 3000, '夏の定番大玉スイカ'),
    ('メロン', 5000, 'クイーンメロン高級品'),
    ('もも', 600, 'ジューシーな山梨産桃'),
    ('なし', 400, 'シャリシャリ食感の梨');
