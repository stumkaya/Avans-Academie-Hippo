<#include "../../include/imports.ftl">
<#setting locale="nl_NL">
<#setting date_format="d MMMM">
<#if document??>
<div class="component-content component-content--less-margin">
    <#if document.stickymenuitem?? && document.stickymenuitem?has_content>
      <a class="anchor" id="${document.stickymenuitem?lower_case?replace(" ", "_")}" data-name="${document.stickymenuitem}"></a>
    </#if>
    <#if document.title?? && document.title?has_content>
      <header>
          <#if document.chapeau?? && document.chapeau?has_content>
            <span class="chapeau">
            ${document.chapeau}
            </span>
          </#if>
        <h2>${document.title}</h2>
      </header>
    </#if>
    <@hst.cmseditlink hippobean=document/>
    <@hst.html hippohtml=document.content/>
</div>
</#if>
