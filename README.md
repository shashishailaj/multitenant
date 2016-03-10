# Mulit-Tenant AuthN/AuthZ Sample
This idea behind this multi-tenant application is that one company (who I will refer to as the **provider**) owns a set of web services that they host in their domain and have registered in their Azure Active Directory. They have multiple technologies that they use to host these services (Node.js, .NET WCF, .NET Web API, Java, etc.).

There are multiple other companies (who I will refer to as **consumers**) that will consume those services using a variety of clients (HTML/JS, mobile apps, WPF apps, etc.). These consumers will manage their own users and groups via their own Active Directory systems.

There are a variety of pieces provided:
- A Node.js server presenting a simple HTML/JS site and REST/JSON services
  - AuthN/AuthZ can be via Azure AD, LDAP, or client certificate (Coming Soon)
  - A JSON Web Token is always provided regardless of 
- A JavaScript client that can consume those services after authenticating
- A WCF client that can consume those services after authenticating
- A WebAPI client that can consume those services after authenticating
- A WPF client that can consume those services after authenticating
- (Coming Soon) A WPF client that is on a trusted endpoint that can consume those services after authenticating
- (Coming Soon) A Java server providing the same functionality as the Node.js server

## Samples
Click on any of the following to understand the specifics of the configuration:
- [Node.js server](/docs/nodejs.md)
- JavaScript client
- WCF client
- WebAPI client
- WPF client
- Trusted WPF client