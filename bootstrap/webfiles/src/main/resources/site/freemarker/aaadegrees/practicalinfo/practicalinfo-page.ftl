<#include "../../include/imports.ftl">
<#-- @ftlvariable name="document" type="nl.avans.beans.Practicalinfo" -->
<#setting locale="nl_NL">
<#setting date_format="d MMMM">
<#if document??>

<div class="container">
  <div class="row">
    <section class="col-xs-12">
      <div class="component-overview">
        <div class="row">
          <div class="col-xs-12 col-sm-7">
            <p class="lead">
            ${document.introduction}
            </p>
          </div>
        </div>

        <div class="row cards">
            <#list document.blocks as block>
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
            </#list>
        </div>
      </div>
    </section>
  </div>
</div>



</#if>