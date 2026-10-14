#!/usr/bin/env python3
"""
Claude API 基础示例（Python）

依赖安装：
pip install anthropic

运行前设置环境变量：
export ANTHROPIC_API_KEY="your-api-key-here"
"""

import anthropic


def main():
    # 创建客户端（自动从环境变量读取 API key）
    client = anthropic.Anthropic()

    # 创建消息
    message = client.messages.create(
        model="claude-opus-5-5",
        max_tokens=1024,
        messages=[
            {"role": "user", "content": "你好，请用一句话介绍你自己。"}
        ]
    )

    # 输出响应
    print("Claude 的回复：")
    print(message.content[0].text)

    # 输出 token 使用情况
    print("\nToken 使用：")
    print(f"输入: {message.usage.input_tokens}")
    print(f"输出: {message.usage.output_tokens}")


if __name__ == "__main__":
    main()
