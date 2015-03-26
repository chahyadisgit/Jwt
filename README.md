# Jwt
JSON Web Token

#### Requirement
<ol>
<li>Jdk 1.8x</li>
<li>Maven 3.x</li>
</ol>

#### JwtObject
Model yang digunakan untuk transaksi JwtClient & JwtServer

#### JwtClient
Library untuk generate token

#### JwtServer
Library untuk verified token.<br/>
Berikut ini adalah bagian yang akan di validasi:
<ul>
<li>token format (signingInput &gt;&gt; <b>&lt;header&gt;.&lt;claim&gt;</b>)</li>
<li>signature</li>
<li>query string (qsh)</li>
<li>the issuer of the claim (iss)</li>
<li>expiration token</li>
</ul>

##### Project Status
on progress
