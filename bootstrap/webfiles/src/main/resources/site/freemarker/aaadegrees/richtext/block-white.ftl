<#include "../../include/imports.ftl">
<#setting locale="nl_NL">
<#setting date_format="d MMMM">
<div class="component-widget widget-white">
  <header>
    <h3 class="panel-title">${document.title}</h3>
  </header>
  <div>
  <@hst.html hippohtml=Request.document.content/>
<#--    <ul class="link-list">
      <li><a href="#">Vergelijk het hier</a></li>
    </ul>-->
  </div>
</div>

