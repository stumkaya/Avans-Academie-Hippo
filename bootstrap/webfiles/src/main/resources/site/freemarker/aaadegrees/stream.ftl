<#include "../include/imports.ftl">

<#-- @ftlvariable name="documentList" type="java.util.ArrayList<HippoBean>" -->

<div class="row streamer__row">
  <div id="streamer-carousel" class="owl-carousel owl-theme streamer__carousel">
  <#list documentList as document>
    <div class="streamer__item" style="background-image: url(<@hst.link hippobean=document.image/>)">
      <div class="streamer__skew"></div>
        <#if document.class=="class nl.avans.beans.EventsDocument">
          <div class="streamer__text">
            <div class="streamer__type">
              <span>Evenement</span>
            </div>
            <#if document.title1??><div class="streamer__title">
              <span>${document.title1}</span>
            </div></#if>
          </div>
          <a class="streamer__read-more" href="<@hst.link hippobean=document/>">
            <span>Lees verder</span>
          </a>
        <#elseif document.class=="class nl.avans.beans.NewsDocument">
          <div class="streamer__text">
            <div class="streamer__type">
              <span>Nieuws</span>
            </div>
            <div class="streamer__title">
              <span>${document.title}</span>
            </div>
          </div>
          <a class="streamer__read-more" href="<@hst.link hippobean=document/>">
            <span>Lees verder</span>
          </a>
        <#elseif document.class=="class nl.avans.beans.Streamitem">
          <div class="streamer__text">
            <div class="streamer__type">
              <span>${document.chapeau}</span>
            </div>
            <div class="streamer__title">
              <span>${document.title}</span>
            </div>
          </div>
          <a class="streamer__read-more" href="${document.url}">
            <span>Lees verder</span>
          </a>
        </#if>
    </div>
  </#list>
  </div>
</div>
