<#include "../../include/imports.ftl">
<#-- @ftlvariable name="document" type="nl.avans.beans.Practicalinfo" -->
<#setting locale="nl_NL">
<#setting date_format="d MMMM">
<#if document??>


<div class="container">
  <div class="row">
    <section class="col-xs-12">
      <div class="component-facilities">
          <#if document.stickymenuitem?? && document.stickymenuitem?has_content>
            <a class="anchor" id="${document.stickymenuitem?lower_case?replace(" ", "_")}" data-name="${document.stickymenuitem}"></a>
          </#if>

        <header>
          <!--<span class="chapeau">Cras commodo lacinia</span>-->
          <h2>Faciliteiten</h2>
        </header>

        <div class="row cards">
            <#list document.blocks as block>
              <div class="col-sm-6 col-md-4">
                <div class="image-card">
                  <div>
                    <img src="<@hst.link hippobean=block.image/>" alt="<#if block.image.description??>${block.image.description}</#if>"/>
                  </div>
                  <header>
                    <h3>${block.title}</h3>
                    <p>${block.description}</p>
                  </header>
                </div>
              </div>
            </#list>
        </div>
      </div>
    </section>
  </div>
</div>



</#if>