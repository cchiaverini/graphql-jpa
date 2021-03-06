package org.crygier.graphql.model.collections;

import groovy.transform.CompileStatic;
import org.crygier.graphql.annotation.SchemaDocumentation;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable
import javax.persistence.Column

@Entity
@CompileStatic
public class CollectionEntity {

    //testing that the Schema Builder does not break
    //when building collection of non-enum objects

    @Id
    @SchemaDocumentation("Primary Key for the CollectionTest Class")
    String id;

    @SchemaDocumentation("A List of Strings")
    @ElementCollection(targetClass=String.class)
	@CollectionTable(
		  name="STRINGS",
		  joinColumns=@JoinColumn(name="OWNER_ID")
	)
	@Column(name="VALUE")
    List<String> strings = new ArrayList<String>();
	
	@SchemaDocumentation("A List of Objects")
    @ElementCollection
	@CollectionTable(
		  name="OBJECTS",
		  joinColumns=@JoinColumn(name="OWNER_ID")
	)
	@Column(name="VALUE")
	List<EmbeddedObject> objects = new ArrayList<EmbeddedObject>();
}

