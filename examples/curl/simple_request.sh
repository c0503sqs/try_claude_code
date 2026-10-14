#!/bin/bash
# Claude API cURL 示例
# 最简单的测试方式，不需要任何 SDK

# 运行前设置环境变量
# export ANTHROPIC_API_KEY="your-api-key-here"

curl https://api.anthropic.com/v1/messages \
  -H "content-type: application/json" \
  -H "x-api-key: $ANTHROPIC_API_KEY" \
  -H "anthropic-version: 2023-06-01" \
  -d '{
    "model": "claude-opus-5-5",
    "max_tokens": 1024,
    "messages": [
      {"role": "user", "content": "你好，请用一句话介绍你自己。"}
    ]
  }' | jq '.'

# 说明：
# - jq 是 JSON 格式化工具，可选安装
# - 如果不装 jq，去掉最后的 | jq '.'
# - 响应会包含完整的 JSON，包括 content、usage 等字段
