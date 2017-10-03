<#include "../include/imports.ftl">
<#-- @ftlvariable name="document" type="nl.avans.beans.Practicalinfo" -->

<#if document??>

<div class="component-overview">

    <#if document.stickymenuitem?? && document.stickymenuitem?has_content>
        <a class="anchor" id="${document.stickymenuitem}" name="${document.stickymenuitem}" class="anchor" data-name="${document.stickymenuitem}"></a>
    </#if>

<#--  <header>
    <span class="chapeau">${document.chapeau}</span>
    <h2>${document.getTitle()}</h2>
  </header>-->

  <div class="row cards">
    <#list document.blocks as block>
        <#if !block.image?? || !block.image?has_content>
            <div class="col-sm-6 col-md-4">
                <a href="<#if block.link??>${block.link}</#if>" class="card">
                  <header>
                    <h3>${block.title}</h3>
                  </header>
                  <div>
                    <p>${block.description}</p>
                    <span>Lees verder</span>
                  </div>
                </a>
            </div>
        </#if>
    </#list>

    <#list document.blocks as block>
        <#if block.image?? && block.image?has_content>
          <div class="col-sm-12 col-md-6">
            <a href="<#if block.link??>${block.link}</#if>" class="image-card">
              <div>
                <img src="<@hst.link hippobean=block.image/>" alt="<#if block.image.description??>${block.image.description}</#if>"/>
              </div>
              <header>
                <h3>${block.title}</h3>
              </header>
            </a>
          </div>
        </#if>
    </#list>

  </div>
</div>

</#if>