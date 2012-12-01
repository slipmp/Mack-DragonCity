<%@ include file="/inc/init.jsp" %>
<c:set var="navArr" value="${fn:split(nav, '#')}"/>

<ol>
	<li><a <c:if test="${fn:contains(navArr[0], 'Listar Jogadores')}"> class="selected"</c:if> 
			href="<c:url value="/adm/listarJogadores.jsp" />" title="Listar Jogadores">Listar Jogadores</a></li>	
</ol>

<c:choose>
	<c:when test="${navArr[0] eq 'menu1'}">
		<ul id="submenu" class="left">
			<li <c:if test="${navArr[1] eq 'subMenu1'}">class="selected"</c:if>>
				<a href="subMenu1" title="subMenu1">SubMenu1</a>
			</li>
			<li <c:if test="${navArr[1] eq 'subMenu2'}">class="selected"</c:if>>
				<a href="subMenu2" title="subMenu2">SubMenu2</a>
			</li>			
		</ul>
	
	</c:when>
</c:choose>