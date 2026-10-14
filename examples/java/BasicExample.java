package com.example;

import com.anthropic.AnthropicClient;
import com.anthropic.models.messages.Message;
import com.anthropic.models.messages.MessageCreateParams;
import com.anthropic.models.messages.Model;

/**
 * Claude API 基础示例
 *
 * 依赖：com.anthropic:anthropic-java:最新版本
 *
 * 运行前设置环境变量：
 * export ANTHROPIC_API_KEY="your-api-key-here"
 */
public class BasicExample {

    public static void main(String[] args) {
        // 创建客户端（自动从环境变量读取 API key）
        AnthropicClient client = AnthropicClient.builder()
            .build();

        // 创建消息
        MessageCreateParams params = MessageCreateParams.builder()
            .model(Model.CLAUDE_OPUS_5_5)
            .maxTokens(1024)
            .addUserMessage("你好，请用一句话介绍你自己。")
            .build();

        // 发送请求
        Message message = client.messages().create(params);

        // 输出响应
        System.out.println("Claude 的回复：");
        System.out.println(message.content().get(0).text().get());

        // 输出 token 使用情况
        System.out.println("\nToken 使用：");
        System.out.println("输入: " + message.usage().inputTokens());
        System.out.println("输出: " + message.usage().outputTokens());
    }
}
