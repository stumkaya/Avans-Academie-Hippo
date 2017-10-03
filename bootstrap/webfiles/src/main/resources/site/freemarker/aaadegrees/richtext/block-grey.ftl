<#include "../../include/imports.ftl">
<#setting locale="nl_NL">
<#setting date_format="d MMMM">
<div class="component-widget widget-gray">
  <header>
    <h3 class="panel-title">${document.title}</h3>
  </header>
  <div>
    <@hst.html hippohtml=Request.document.content/>
  </div>
</div>
