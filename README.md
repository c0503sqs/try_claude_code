# Claude Code 学习资料

这个仓库用来存放 Claude Code 的学习资料、代码示例和实践经验。

## 目录结构

```
docs/           # 文档和学习笔记
examples/       # 代码示例
  java/         # Java 示例（Spring Boot + Claude API）
  python/       # Python 示例（anthropic SDK）
  curl/         # cURL 命令示例（快速测试）
scripts/        # 辅助脚本
.claude/        # Claude Code 项目配置
```

## 快速开始

### 1. 安装 Claude Code

```bash
# macOS/Linux
curl -fsSL https://claude.ai/install.sh | bash

# 验证安装
claude --version
```

### 2. 配置 API Key

```bash
# 方式 1：环境变量
export ANTHROPIC_API_KEY="your-api-key-here"

# 方式 2：使用 Claude CLI 登录
claude login
```

### 3. 运行示例

```bash
# Java 示例（需要先编译）
cd examples/java
mvn clean compile
mvn exec:java -Dexec.mainClass="com.example.ClaudeExample"

# Python 示例
cd examples/python
python basic_example.py

# cURL 示例
cd examples/curl
bash simple_request.sh
```

## Git 命令速查（给 SVN 用户）

| SVN 命令 | Git 等价命令 | 说明 |
|---------|------------|------|
| `svn checkout` | `git clone` | 下载仓库 |
| `svn add` | `git add` | 添加文件到暂存区 |
| `svn commit` | `git commit` | 提交到本地仓库 |
| `svn update` | `git pull` | 拉取远程更新 |
| `svn status` | `git status` | 查看文件状态 |
| `svn diff` | `git diff` | 查看修改 |
| `svn log` | `git log` | 查看提交历史 |
| `svn revert` | `git checkout -- <file>` | 撤销修改 |

### Git 独有的概念

```bash
# 查看提交历史（图形化）
git log --oneline --graph --all

# 创建分支
git branch feature-name

# 切换分支
git checkout feature-name

# 合并分支
git merge feature-name

# 推送到远程
git push origin main
```

## Claude Code 常用命令

```bash
# 启动交互式会话
claude

# 直接执行命令
claude "解释这段代码"

# 查看配置
claude config list

# 更新到最新版本
claude update

# 查看帮助
claude --help
```

## 资源链接

- [Claude Code 官方文档](https://docs.anthropic.com/en/docs/claude-code)
- [Claude API 文档](https://docs.anthropic.com/en/docs/intro-to-claude)
- [Anthropic SDK (Java)](https://github.com/anthropics/anthropic-sdk-java)
- [Anthropic SDK (Python)](https://github.com/anthropics/anthropic-sdk-python)
