---
title: Zero Trust
theme: white
revealOptions:
  transition: 'fade'
---

# ZTA

---

The transition to Zero Trust Architecture (ZTA) is a journey, and change does not happen all at once.

---

Any organization undergoing the transition to Zero Trust Architecture must acknowledge and accept that progress will happen incrementally and that the organization and its environment must evolve continuously.

---

## Zero Trust Commandments

---

### Validate Trust Explicitly

Security assurance shall rely on explicitly validating trust decisions using all relevant available information and telemetry.

---

#### Validate Trust Explicitly

* <!-- .element class="fragment" -->  Verify Access Control
* <!-- .element class="fragment" --> Verify Application Development
* <!-- .element class="fragment" --> Verify Technology Supply Chain
* <!-- .element class="fragment" --> Verify Host Configuration
* <!-- .element class="fragment" --> Verify Incident Processes

Notes:

* The organization must validate user authentication strength, session context, and device integrity before allowing a user or device to access the organization’s assets (and continuously during each session if available).

* The organization must define and follow secure development lifecycle processes and infrastructure as code and verify that they are followed.

* The organization must be able to verify on-demand the provenance and integrity (i.e., lack of counterfeiting or tainting) of technology components.

* The organization must be able to verify on-demand that operational deployment complies with the security control requirements established per platform.

* The organization must be able to verify security and business continuity processes (e.g., ability to detect and respond to incidents, including restoring business operations).

---

### Enable Modern Work

Security discipline shall enable productivity and manage risk as the organizational capabilities, goals, environment, and infrastructure continuously evolve.

---

#### Enable Modern Work

* <!-- .element class="fragment" --> Work Anywhere
* <!-- .element class="fragment" --> Align to Mission
* <!-- .element class="fragment" --> Assign Security Risk to Asset Owners
* <!-- .element class="fragment" --> Align Risk Management

Notes:

* People must be able to work on any network, in any location, with appropriate security assurances and access restrictions. People should have access to all applications required to do their jobs.

* Security strategy, success metrics, and policies must map directly to the organizational mission and business model or plan.

* The organization must assign accountability for security risk to business asset owners, like all other risks. Security teams must act as subject-matter experts to advise asset owners on security risk.

* The organization must measure and manage risk using its risk management framework and processes (thresholds, prioritization, stakeholders, etc.).

---

### Enable Pervasive Security

Security discipline shall be integrated into the culture, norms, and processes throughout the organization.

---

#### Enable Pervasive Security

* <!-- .element class="fragment" --> Integrate in Business Environment
* <!-- .element class="fragment" --> Integrate in Technical Environment
* <!-- .element class="fragment" --> Incorporate Security Education and Awareness Training

Notes:

* The organization must integrate security context into business strategy, planning, operations, acquisition, contracting, and outsourcing.

* The organization must integrate security controls into modern workflows, application and solution architectures, migrations to hybrid-cloud and cloud environments, new application development, Artificial Intelligence (AI) and Machine Learning (ML) projects, implementation of agile practices, and other emerging technologies.

* The organization must incorporate security education and awareness training for employees, partners, contractors, and suppliers to demonstrate the importance of Zero Trust and how it should be adopted in new acquisitions, application development, and IT changes on a regular basis so that it is understood and adopted throughout the entire lifecycle.

---

### Secure Assets by Value

Security controls shall be designed to protect business assets appropriate to their business value and expected risk.

---

#### Secure Assets by Value

* <!-- .element class="fragment" --> Map Technology to Business
* <!-- .element class="fragment" --> Classify Information Assets
* <!-- .element class="fragment" --> Increase Security for Sensitive Assets
* <!-- .element class="fragment" --> Reduce Unneeded Sensitivity
* <!-- .element class="fragment" --> Stay Current

Notes:

* The organization must identify important business assets and translate them into technical assets[3] that compose them, including consideration of systems with direct administrative control.

* Organizations should classify mission-critical assets that drive certain business process (e.g., for insurance companies, a business process can be life insurance, health, savings, retirements, etc.) essential to meeting end-client business objectives. The classification of assets will support arriving at Confidentiality, Integrity, and Availability (CIA) ratings.

* Security controls must match asset value and sensitivity to ensure protection of high-value data and applications.

* The organization must reduce asset sensitivity where possible to avoid wasting efforts of security and other teams (e.g., retire or replace unneeded sensitive assets, remove sensitive or regulated data with low-value tokens, etc.).

* The organization must update security assurances for the asset (CIA, safety) as the asset use-cases, threats, and value change over time.

---

### Implement Asset-Centric Controls

Asset-specific security controls (versus broad infrastructure controls) shall be implemented whenever available to minimize disruption of productivity and increase precision of security/business visibility.

---

#### Implement Asset-Centric Controls

* <!-- .element class="fragment" --> Implement Data-Centric Controls
* <!-- .element class="fragment" --> Implement Application-Centric Controls
* <!-- .element class="fragment" --> Determine Trust beyond the Network

Notes:

* Data-centric security controls must enable appropriate protection for data in any location and on any network.

* Application-centric security controls must help ensure workloads are protected on any location (cloud, on-premise, or otherwise), including when attackers can access the corporate network. This may include controls on the application itself or application-aware infrastructure controls (identity, network, etc.) that focus on the context of the application, its users, and related context (sometimes called micro-segmentation).

* Broad network security controls (not application-centric) must be focused on proven use-cases, such as filtering basic Internet traffic, isolating networks with legacy applications or devices (e.g., Operational Technology (OT)), meeting regulatory requirements, and providing high-quality threat detections (e.g., high true positive rate). This is because a network does not impart trust on an asset; network security controls can protect assets, but cannot protect “the network” itself and derive asset security or trust from it.

---

### Enable Simple and Sustainable Security

Security controls shall be as simple as possible while remaining practicable, scalable, and sustainable for the full lifecycle of the business asset.

---

#### Enable Simple and Sustainable Security

* <!-- .element class="fragment" --> Simplify Human Experience
* <!-- .element class="fragment" --> Simplify Security
* <!-- .element class="fragment" --> Provide Clarity
* <!-- .element class="fragment" --> Configure before Customize
* <!-- .element class="fragment" --> Secure for the Full Lifecycle
* <!-- .element class="fragment" --> Utilize an End-to-End Approach

Notes:

* Security controls must minimize manual steps required and workflow disruption for business users and IT personnel, including providing self-service resolution where possible.

* The organization must favor automated controls and reporting for security risk to enable security teams to execute at speed commensurate with the organization.

* The organization must clearly define accountability, written policy, and aspirational visions to enable consistent security decision-making.

* The organization must base security controls on accepted best practices and implemented (incrementally or fully) within a reasonable time considering available resources – people, process, technology, time. To the degree possible, standardize on organization-wide platforms for IT and security to ensure consistent visibility, management, and control.

* Security programs and strategies must cover the full lifecycle of the business asset, including identify, protect, detect, respond, and recover.

* Security governance must sustain security assurances for the full lifecycle of the data, transaction, or relationship.

---

### Utilize Least Privilege

Access to systems and data shall be provided only as required, and access shall be removed when no longer required.

---

#### Utilize Least Privilege

* <!-- .element class="fragment" --> Grant Just Enough Access
* <!-- .element class="fragment" --> Grant Just-in-Time Access
* <!-- .element class="fragment" --> Utilize Adaptive Access

Notes:

* The organization must limit access (for a person, in a session, etc.) to only the systems and data required to perform a task.

* The organization must provide access on-demand, as needed, and only with appropriate approval and validation.

* The organization must adjust access permissions over the lifetime of the session in real time (as possible) and the lifetime of the account to prevent accumulation of unneeded privilege and unnecessary risk.

---

### Improve Continuously

Security teams shall continuously evolve and improve to remain successful in an environment that constantly changes.

---

#### Improve Continuously

* <!-- .element class="fragment" --> Consider People, Process, and Technology
* <!-- .element class="fragment" --> Consider Business Evolution
* <!-- .element class="fragment" --> Consider Technical Evolution
* <!-- .element class="fragment" --> Consider Security Evolution

Notes:

* Security teams must continuously improve all aspects of the security program, tooling, and skills, constantly monitoring and seeking and applying feedback.

* Security teams must continuously adapt to evolving business drivers and models, preventing the creation of obstacles for business and/or mission success through either action or inaction.

* Security teams must continuously adapt to feature and product release and adoption cycles of technology.

* Security teams must continuously monitor and adjust to current and future threats as they emerge, as well as new best practices, architectures, technologies, etc.

---

### Make Informed Decisions

Security teams shall make informed decisions based on the best information that can be made available.

---

#### Make Informed Decisions

* <!-- .element class="fragment" --> Decide with Data
* <!-- .element class="fragment" --> Constantly Gather Telemetry
* <!-- .element class="fragment" --> Prioritize using Data
* <!-- .element class="fragment" --> Combine Data with Human Wisdom
* <!-- .element class="fragment" --> Constantly Grow your Telemetry

Notes:

* Security teams must use all applicable data to inform security decisions regarding access control, anomaly detection and investigation, risk assessment, planning, design, etc.

* Security teams must build and sustain a current and accurate understanding of the technical environment by continuously monitoring all assets (services, apps, identities, data, etc.) for insights and anomalous patterns.

* The organization must prioritize security investments based on risk analyses informed by current information on active threat actors and technical attack techniques (from the organization, industry peers, and other organizations).

* Security teams must minimize the impact of any decision bias by applying critical thinking and human experience to available data. Consider any differences between actual and expected outputs as learning opportunities to examine further.

* Security teams must continuously seek new information sources as the organization’s business model, technical platforms, threats, and security capabilities evolve. Security teams must constantly increase visibility into known assets, discovery of expected assets, and discovery of new asset types.