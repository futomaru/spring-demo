# spring-demo

Spring Boot で作られたシンプルな CRUD サンプルプロジェクト

## 目的
アイテム情報の登録・検索・削除など、基本的な CRUD 操作を学ぶためのサンプルです。

## 起動方法
```sh
./gradlew bootRun
```
または
```sh
./gradlew build
java -jar build/libs/*.jar
```

## API/画面
- 一覧取得: `GET /api/items/all`
- 名前検索: `GET /api/items/search?name=foo`
- 追加: `POST /api/items/create`（JSONボディ）
- 削除: `DELETE /api/items/delete?id=1`
- Web画面: `http://localhost:8080/`（Thymeleafによる簡易UI）

## 構成
- controller: REST APIや画面のエンドポイント
- service: ビジネスロジック
- repository: DBアクセス（MyBatis）
- model: エンティティ/DTO
- resources: 設定・テンプレート・静的ファイル

## 技術スタック
- Java 25
- Spring Boot 4
- Spring Framework 7
- MyBatis
- H2 Database（組み込みDB）
- Thymeleaf（テンプレートエンジン）
- Gradle

