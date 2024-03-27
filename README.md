DEV-Server starten
----------------------------------
cd frontend
npm run dev


Mailserver starten
-----------------------------------
$ brew install mailhog

$ brew services start mailhog

$ open http://127.0.0.1:8025

$ sudo postfix stop && sudo postfix start

$ date | mail -s "Test Email" d.ehmann@gmx.de


Configuration
------------------------------------
- Server-Ports ändern in der nuxt.config.js

- api-basedomain ist http://localhost:3000 wird in "api/index.js" geändert. Dann auf 8080?

- Währung umstellen in filters.js