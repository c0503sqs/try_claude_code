package com.xm;

import com.anthropic.client.AnthropicClient;
import com.anthropic.client.okhttp.AnthropicOkHttpClient;
import com.anthropic.models.messages.Message;
import com.anthropic.models.messages.MessageCreateParams;

/**
 * Claude API 基础示例：发送一条消息并打印回复。
 *
 * 依赖：com.anthropic:anthropic-java
 *
 * 运行前设置环境变量（二选一）：
 *   export ANTHROPIC_API_KEY="sk-ant-..."        # 官方 API
 *   export ANTHROPIC_AUTH_TOKEN="..."            # 兼容端点（Bearer 认证）
 * 可选：
 *   export ANTHROPIC_BASE_URL="..."              # 自定义兼容端点
 *   export ANTHROPIC_MODEL="claude-opus-5-5"     # 覆盖默认模型
 */
public class BasicExample {

    public static void main(String[] args) {
        // 创建客户端（自动读取 ANTHROPIC_API_KEY / ANTHROPIC_AUTH_TOKEN / ANTHROPIC_BASE_URL）
        AnthropicClient client = AnthropicOkHttpClient.fromEnv();

        String model = System.getenv().getOrDefault("ANTHROPIC_MODEL", "claude-opus-5-5");

        // 构建请求
        MessageCreateParams params = MessageCreateParams.builder()
            .model(model)
            .maxTokens(1024L)
            .addUserMessage("你好，请用一句话介绍你自己。")
            .build();

        // 发送请求
        Message message = client.messages().create(params);

        // 输出回复（content 可能包含多个 block，逐个打印文本块）
        System.out.println("Claude 的回复：");
        message.content().stream()
            .flatMap(block -> block.text().stream())
            .forEach(text -> System.out.println(text.text()));

        // 输出 token 使用情况
        System.out.println("\nToken 使用：");
        System.out.println("输入: " + message.usage().inputTokens());
        System.out.println("输出: " + message.usage().outputTokens());

        client.close();
    }
}
