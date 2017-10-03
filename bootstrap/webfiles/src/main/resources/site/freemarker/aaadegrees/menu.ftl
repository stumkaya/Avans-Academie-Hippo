<#include "../include/imports.ftl">
<#if menu??>
<div class="col-xs-12 col-sm-3">
  <ul>
      <#list menu.siteMenuItems as item>
          <#if item.name?starts_with('Separator')>
              </ul>
              <ul>
          <#elseif !item.hstLink?? && !item.externalLink??>
            <li>${item.name?html}
          <#else>
              <#if item.hstLink??>
                  <#assign href><@hst.link link=item.hstLink/></#assign>
              <#elseif item.externalLink??>
                  <#assign href>${item.externalLink?replace("\"", "")}</#assign>
              </#if>
          <li><a href="${href}">${item.name?html}</a>
          </#if>

          <#if item.childMenuItems?? && item.childMenuItems?size!=0>
            <ul>
          </#if>
          <#list item.childMenuItems as subitem>
              <#if !subitem.hstLink?? && !subitem.externalLink??>
                  <#if subitem.selected || subitem.expanded>
                    <li class="active">
                      <div>${subitem.name?html}</div>
                    </li>
                  <#else>
                    <li>
                      <div>${subitem.name?html}</div>
                    </li>
                  </#if>
              <#else>
                  <#if subitem.hstLink??>
                      <#assign href><@hst.link link=subitem.hstLink/></#assign>
                  <#elseif subitem.externalLink??>
                      <#assign href>${subitem.externalLink?replace("\"", "")}</#assign>
                  </#if>
                  <#if  subitem.selected || subitem.expanded>
                    <li class="active"><a href="${href}">${subitem.name?html}</a></li>
                  <#else>
                    <li><a href="${href}">${subitem.name?html}</a></li>
                  </#if>
              </#if>
          </#list>
          <#if item.childMenuItems?? && item.childMenuItems?size!=0>
          </ul>
          </#if>
      </li>
      </#list>
  </ul>
    <@hst.cmseditmenu menu=menu/>
</div>
<#-- @ftlvariable name="editMode" type="java.lang.Boolean"-->
<#elseif editMode>
<img src="<@hst.link path="/images/essentials/catalog-component-icons/menu.png" />"> Click to edit Menu
</#if>

