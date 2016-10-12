package com.outr.lucene4s.document

import com.outr.lucene4s.Lucene
import com.outr.lucene4s.facet.FacetValue
import com.outr.lucene4s.field.value.FieldAndValue
import org.apache.lucene.document.Document

class DocumentBuilder(lucene: Lucene, document: Document = new Document) {
  def add[T](fieldAndValue: FieldAndValue[T]): DocumentBuilder = {
    fieldAndValue.write(document)
    this
  }

  def add(facetValue: FacetValue): DocumentBuilder = {
    facetValue.write(document)
    this
  }

  def index(): Unit = lucene.store(document)
}