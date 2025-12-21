# spring-ai-demo

Spring AI の MCP サーバーを使って、アイテム（果物）の CRUD 操作を試せるデモアプリです。

## クイックスタート

```sh
./gradlew bootJar
java -jar build/libs/spring-ai-demo-0.0.1-SNAPSHOT.jar
```

起動後、標準入出力で JSON-RPC 通信できます。

## 使い方

### ClientStdio で動作確認

```sh
./gradlew --quiet run -PmainClass=com.example.demo.client.ClientStdio
```

全ツール（listItems / searchItemsByName / registerItem / updateItem / removeItem）を順番に実行します。

### Claude Desktop との連携

Claude Desktop の MCP 設定に以下を追加：

```json
{
  "mcpServers": {
    "spring-ai-demo": {
      "command": "java",
      "args": ["-jar", "/path/to/build/libs/spring-ai-demo-0.0.1-SNAPSHOT.jar"]
    }
  }
}
```

Claude から `listItems` などのツールを呼び出せます。

## 提供ツール

| ツール名 | 説明 |
| --- | --- |
| `listItems` | 全アイテムを一覧表示 |
| `searchItemsByName` | 名前で検索 |
| `registerItem` | 新規登録 |
| `updateItem` | 既存アイテムを更新 |
| `removeItem` | アイテムを削除 |

---

**技術スタック**: Java 25 / Spring Boot 4 / Spring AI / MyBatis / H2 Database

