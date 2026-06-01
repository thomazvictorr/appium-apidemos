# 📱 Automação de Testes Mobile — ApiDemos

![Build](https://github.com/thomazvictorr/appium-apidemos/actions/workflows/ci.yml/badge.svg)

Projeto de automação de testes mobile com **Appium + Java**, utilizando o app [ApiDemos](https://github.com/appium/appium) como alvo dos testes.

---

## 🧪 Cobertura de Testes

| Teste | Descrição |
|-------|-----------|
| CT-001 | Navegar para Hello World e validar texto |
| CT-002 | Validar activity atual ao abrir Hello World |
| CT-003 | Realizar scroll até WebView na lista de Views |
| CT-004 | Realizar drag and drop entre elementos |
| CT-005 | Navegar para Views e voltar para tela inicial |
| CT-006 | Validar itens principais na tela inicial |

**Total: 6 casos de teste** com JUnit 5 e Page Object base

---

## 🏗️ Estrutura do Projeto

```
├── src/
│   └── test/
│       ├── java/br/com/thomazvictorr/
│       │   ├── base/
│       │   │   └── BaseTest.java        # Configuração do driver
│       │   └── tests/
│       │       └── ApiDemosTest.java    # Casos de teste
│       └── resources/
│           └── ApiDemos-debug.apk       # App alvo (não versionado)
├── .github/
│   └── workflows/
│       └── ci.yml                       # Pipeline GitHub Actions
└── pom.xml
```

---

## 🚀 Como executar localmente

**Pré-requisitos:**
- Java 17+
- Maven 3.9+
- Appium Server 2.x (`npm install -g appium`)
- Driver UIAutomator2 (`appium driver install uiautomator2`)
- Android Studio com emulador configurado (API 33+)
- APK do ApiDemos em `src/test/resources/`

```bash
# Instalar dependências
mvn install -DskipTests

# Iniciar Appium Server (em outro terminal)
appium

# Iniciar emulador Android (em outro terminal)
# Android Studio → Device Manager → Play

# Executar testes
mvn test
```

---

📄 **[Ver página do projeto](https://thomazvictorr.github.io/appium-apidemos/)**

---

## ⚙️ CI/CD com GitHub Actions

O pipeline roda automaticamente a cada **push** ou **pull request** na branch `main`.

Como testes mobile precisam de emulador Android, o CI realiza:
- ✅ Compilação do projeto
- ✅ Validação de dependências e estrutura
- ✅ Compilação dos testes
- ⚠️ Execução dos testes — requer emulador, rodar localmente

---

## 🛠️ Tecnologias

- [Appium](https://appium.io/) — framework de automação mobile
- [Java 17](https://adoptium.net/) — linguagem de programação
- [JUnit 5](https://junit.org/junit5/) — framework de testes
- [Maven](https://maven.apache.org/) — gerenciamento de dependências
- [UIAutomator2](https://github.com/appium/appium-uiautomator2-driver) — driver Android
- [GitHub Actions](https://github.com/features/actions) — CI/CD

---

## 👨‍💻 Autor

**Thomáz Victor** — [LinkedIn](https://www.linkedin.com/in/thomazvictorr/) | [GitHub](https://github.com/thomazvictorr)
